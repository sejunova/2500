package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.util.HashMap;

public class CacheMiddleware implements IRequestHandler {
    private IRequestHandler nextRequestHandler;
    private int cacheExpireCount;
    private HashMap<Request, Integer> requestCache = new HashMap<>();

    public CacheMiddleware(IRequestHandler nextRequestHandler, int cacheExpireCount) {
        this.nextRequestHandler = nextRequestHandler;
        this.cacheExpireCount = cacheExpireCount;
    }

    @Override
    public ResultBase handle(Request request) {
        if (this.requestCache.containsKey(request)) {
            int expiryCount = this.requestCache.get(request);
            if (expiryCount > 1) {
                this.requestCache.put(request, --expiryCount);
                return new CachedResult(expiryCount);
            } else {
                this.requestCache.remove(request);
            }
        }

        ResultBase result = nextRequestHandler.handle(request);
        if (new ResultValidator(result).isValid(ResultCode.OK)) {
            this.requestCache.put(request, this.cacheExpireCount);
        }
        return result;
    }
}
