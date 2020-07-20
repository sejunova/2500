package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.HashSet;

public class AuthorizationMiddleware implements IRequestHandler {
    private IRequestHandler nextRequestHandler;
    private HashSet<User> accessibleUsers;

    public AuthorizationMiddleware(IRequestHandler nextRequestHandler, HashSet<User> accessibleUsers) {
        this.nextRequestHandler = nextRequestHandler;
        this.accessibleUsers = accessibleUsers;
    }

    @Override
    public ResultBase handle(Request request) {
        if (!this.accessibleUsers.contains(request.getUser())) {
            return new UnauthorizedResult();
        }
        return this.nextRequestHandler.handle(request);
    }
}
