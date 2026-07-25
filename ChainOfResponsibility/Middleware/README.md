# Design middleware / route-handler

Middlewares are chain of functions where each function has access to `request`, `response` and `next`.

```
m1 (req, res, next) --> m2 (req, res, next) --> m3 (req, res, next)
```

### Requirements ->

1. Route handlers should be able to take the incoming requests and validate the request body.
2. Route handlers should validate request params.
3. Should be capable of authentication via request headers.
4. Once auth is done, route handlers can also do authorization means user is allowed to perform an action or not.
5. If user is authorized then we continue to access the controller layer.

### Things to keep in mind while designing a route handler ->

1. A route handler is capable of modifying request object and pass it to the next handler.
2. In case the validation vails, route handler should return the request midway without calling the next handlers.
3. Handlers can be arranged in any order for a particular route.

