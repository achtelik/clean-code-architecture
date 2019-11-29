package it.achtelik.clean_code_architecture.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.core.importer.ImportOptions;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

public class OnionArchitectureTests {
    private final JavaClasses classes = new ClassFileImporter(new ImportOptions().with(new ImportOption.DoNotIncludeTests()))
            .importPath("it.achtelik.example.javamodules");

    @Test
    public void domain_model_has_no_dependencies_to_domain_service() {
        noClasses().that().resideInAPackage("..domain.models..").should().accessClassesThat().resideInAPackage("..domain.services..").check(classes);
        onionArchitecture()
                .domainModels("..domain.model..")
                .domainServices("..domain.service..")
                .applicationServices("..application.services..")
                .adapter("rest", "..entrypoints.restapis..")
                .adapter("dataproviders", "..dataproviders..");
    }

    /* @Test
     public void domain_has_no_outgoinng_dependencies() {
         noClasses().that().resideInAPackage("..entypoints..").should().accessClassesThat().resideInAPackage("..dataproviders..").check(classes);
         noClasses().that().resideInAPackage("..domain..").should().accessClassesThat().resideInAPackage("..entrypoints..").check(classes);
         noClasses().that().resideInAPackage("..domain..").should().accessClassesThat().resideInAPackage("..restapi..").check(classes);
         noClasses().that().resideInAPackage("..domain..").should().accessClassesThat().resideInAPackage("..serialization..").check(classes);
     }

     @Test
     public void application_has_only_dependencies_to_domain() {
         noClasses().that().resideInAPackage("..application..").should().accessClassesThat().resideInAPackage("..infrastructure..").check(classes);
         noClasses().that().resideInAPackage("..application..").should().accessClassesThat().resideInAPackage("..restapi..").check(classes);
         noClasses().that().resideInAPackage("..application..").should().accessClassesThat().resideInAPackage("..serialization..").check(classes);
     }

     @Test
     public void infrastructure_does_not_depend_on_rest_api() {
         noClasses().that().resideInAPackage("..infrastructure..").should().accessClassesThat().resideInAPackage("..restapi..").check(classes);
     }*/
    @Test
    public void check_entrypoints() {
        noClasses().that().resideInAPackage("..entrypoints.mappers..").should().accessClassesThat().resideInAPackage("..domain.models..").check(classes);
        noClasses().that().resideInAPackage("..entrypoints.models..").should().accessClassesThat().resideInAPackage("..domain.models..").check(classes);
        noClasses().that().resideInAPackage("..application..").should().accessClassesThat().resideInAPackage("..serialization..").check(classes);
    }
}
