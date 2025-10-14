package com.acolyptos.encoderapp.application.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.acolyptos.encoderapp.domain.user.model.User;
import com.acolyptos.encoderapp.domain.user.model.UserRoles;
import com.acolyptos.encoderapp.infrastructure.user.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserAppServiceTest {

  @Mock private UserRepositoryImpl userRepositoryImpl;

  @InjectMocks private UserAppService userAppService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testFindUserByUsername_Success() {
    String testUsername = "johndoe";
    UserRoles userRole = new UserRoles();
    userRole.setRoleId(2L);
    userRole.setRoleName("System Admin");
    User mockUser =
        new User(1L, testUsername, "$sdfgnj234#@#%", "John", "D.", "Doe", userRole, true);

    when(userRepositoryImpl.findUserByUsername(testUsername)).thenReturn(mockUser);

    User found = userAppService.findUserByUsername(testUsername);

    assertNotNull(found);
    assertEquals("John", found.getFirstName());
    verify(userRepositoryImpl, times(1)).findUserByUsername(testUsername);
  }
}
