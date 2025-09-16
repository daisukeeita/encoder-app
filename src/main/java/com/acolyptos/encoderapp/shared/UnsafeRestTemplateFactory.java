package com.acolyptos.encoderapp.shared;

import javax.net.ssl.SSLContext;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.apache.hc.core5.ssl.TrustStrategy;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class UnsafeRestTemplateFactory {

  public static RestTemplate create() {
    try {
      // Trust all certs
      TrustStrategy acceptingTrustStrategy = (chain, authType) -> true;

      SSLContext sslContext =
          SSLContextBuilder.create().loadTrustMaterial(acceptingTrustStrategy).build();

      SSLConnectionSocketFactory sslSocketFactory =
          new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

      HttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder
          .create().setSSLSocketFactory(sslSocketFactory).build();

      CloseableHttpClient httpClient =
          HttpClients.custom().setConnectionManager(connectionManager).build();

      return new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));

    } catch (Exception e) {
      throw new RuntimeException("Failed to create unsafe RestTemplate", e);
    }
  }
}
