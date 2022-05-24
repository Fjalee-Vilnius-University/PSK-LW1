package lt.vu.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@MyInterceptor
@Interceptor
public class MYInterceptorImplementation {
    @AroundInvoke
    public Object logMethod(InvocationContext ctx) throws Exception {
        String className = ctx.getMethod().getDeclaringClass().getName();
        String methodName = ctx.getMethod().getName();

        System.out.println("myLogging: " + className + " method " + methodName);
        return ctx.proceed();
    }
}
