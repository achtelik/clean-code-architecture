package it.achtelik.example.javamodules.architecture.entrypoints.restapis;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "it.achtelik.example.javamodules", importOptions = ImportOption.DoNotIncludeTests.class)
public class RestApisTest {

    @ArchTest
    public static ArchRule controller_classes_checks =
            ArchRuleDefinition.classes()
                    .that().resideInAPackage("..entrypoints.restapis..")
                    .should().haveSimpleNameEndingWith("Controller")
                    .andShould().beAnnotatedWith(RestController.class);

    @ArchTest
    public static ArchRule controller_methods_checks =
            ArchRuleDefinition.methods()
                    .that().areDeclaredInClassesThat().resideInAPackage("..entrypoints.restapis..")
                    .and().arePublic()
                    .should().notBeAnnotatedWith(RequestMapping.class)
                    .andShould().haveRawReturnType(ResponseEntity.class);
}
