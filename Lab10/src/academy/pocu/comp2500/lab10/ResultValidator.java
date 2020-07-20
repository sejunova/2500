package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class ResultValidator {
    private ResultBase result;

    public ResultValidator(ResultBase result) {
        this.result = result;
    }

    public boolean isValid(ResultCode code) {
        return this.result.getCode().equals(code);
    }
}
