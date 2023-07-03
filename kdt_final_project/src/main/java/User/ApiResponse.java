package User;

public class ApiResponse {
    private boolean status;
    private String message;

    public ApiResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getter, Setter, toString 생략
}

