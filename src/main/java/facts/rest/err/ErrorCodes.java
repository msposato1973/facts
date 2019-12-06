package facts.rest.err;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCodes {
	BUSINESS_ERROR(100), SERVER_ERROR(500), NETWORK_ERROR(1000);
	 
    private int errorCode;
    private static Map<Integer, ErrorCodes> errorCodeByErrorNumber = new HashMap<Integer, ErrorCodes>();
    
    static {
        for (ErrorCodes errorCode : ErrorCodes.values()) {
            errorCodeByErrorNumber.put(errorCode.getErrorCode(), errorCode);
        }
    }
 
    private ErrorCodes(int errorCode) {
        this.errorCode = errorCode;
    }
 
    public int getErrorCode() {
        return errorCode;
    }
    
    public static ErrorCodes getErrorCodeByNumber(Integer errorNumber) {
        return errorCodeByErrorNumber.get(errorNumber);
    }
}
