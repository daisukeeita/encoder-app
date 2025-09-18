# Encoder Application Workflow

## User/Encoder Feature Flow

```mermaid
sequenceDiagram
    actor Encoder
    participant Login Interface
    participant Authentication Service
    participant Database
    Encoder->>Login Interface: Enter credentials
    Login Interface->>Authentication Service: Verify Credentials
    Authentication Service->>Database: Check Credentials
    Database->>Authentication Service: Result
    alt Valid
    Authentication Service->>Login Interface: Authentication Success
    Login Interface->>Encoder: Display Success Message
    Note left of Encoder: Redirect to Dashboard
    else Invalid
    Authentication Service->>Login Interface: Authentication Failed
    Login Interface->>Encoder: Display Error Message
    Note left of Encoder: Stay on Login Interface
    end
```

> [!NOTE]
> If this doesn't render in your screen, please visit [Mermaid Live
> Editor](https://mermaid.live/edit) and copy the code block.

## Vehicle Feature Flow

```mermaid
sequenceDiagram
    actor Encoder
    participant Search Vehicle Interface
    participant Vehicle Service
    participant LTMS-API
    Encoder->Search Vehicle Interface: Enter Plate Number or MV File Number
    Search Vehicle Interface->>Vehicle Service: Verify Request Body
    Vehicle Service->>LTMS-API: Calls API with verified request Body
    alt Search successful
    LTMS-API->>Vehicle Service: Returns raw vehicle data
    Vehicle Service->>Search Vehicle Interface: Returns processed vehicle data
    Search Vehicle Interface->>Encoder: Displays the processed vehicle data
    Note left of Encoder: Encoder checks the data if it matches with provided <br> Certificate of Registration.
    else Search failed
    Note right of LTMS-API: It throws "400 Bad Request"<br>if the vehicle is not found<br>from their database.
    LTMS-API->>Vehicle Service: Throws a "400 Bad Request" Error
    Vehicle Service->>Search Vehicle Interface: Process the thrown Error to "Vehicle Not Found"
    Search Vehicle Interface->>Encoder: Displays the processed thrown error to the encoder.
    Note left of Encoder: Encoder will ask the customer to visit the nearest <br> LTO Center to update the details of their vehicle.
    end
```

> [!NOTE]
> If this doesn't render in your screen, please visit [Mermaid Live
> Editor](https://mermaid.live/edit) and copy the code block.
