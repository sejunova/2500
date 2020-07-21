package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class ResultValidator {
    private ResultBase result;

    public ResultValidator(ResultBase result) {
        this.result = result;
    }

    public boolean isValid(ResultCode code) {
        boolean typeCheck;
        switch (code) {
            case OK:
                typeCheck = this.result instanceof OkResult;
                break;
            case NOT_FOUND:
                typeCheck = this.result instanceof NotFoundResult;
                break;
            case NOT_MODIFIED:
                typeCheck = this.result instanceof CachedResult;
                break;
            case UNAUTHORIZED:
                typeCheck = this.result instanceof UnauthorizedResult;
                break;
            case SERVICE_UNAVAILABLE:
                typeCheck = this.result instanceof ServiceUnavailableResult;
                break;
            default:
                throw new RuntimeException("Invalid Result Class!!");
        }
        return this.result.getCode().equals(code) && typeCheck;
    }
}
