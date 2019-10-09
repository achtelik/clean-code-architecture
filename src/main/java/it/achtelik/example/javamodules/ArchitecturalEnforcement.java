package it.achtelik.example.javamodules;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareError;
import org.aspectj.lang.annotation.Pointcut;

/**
 * The aspect that is responsible for architecture enforcement:
 * The GUI layer must not access the DAO layer.
 */
@Aspect
public class ArchitecturalEnforcement {

    /**
     * Pointcut for finding join points inside the GUI layer
     */
    @Pointcut("within(*..*entrypoints..*)")
    public void withinGui() {
    }

    /**
     * Pointcut for finding method calls to the DAO layer
     */
    @Pointcut("call(* *..*.services..*(..))")
    public void callDao() {
    }

    /**
     * Advice that defines an error when a GUI method calls a method in the DAO layer
     */
    @DeclareError("withinGui() && callDao()")
    private static final String GUI_MUST_NOT_USE_DAO = "GUI must not access DAO";
}
