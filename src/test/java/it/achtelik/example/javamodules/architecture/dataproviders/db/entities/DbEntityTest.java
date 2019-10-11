package it.achtelik.example.javamodules.architecture.dataproviders.db.entities;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.runner.RunWith;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "it.achtelik.example.javamodules", importOptions = ImportOption.DoNotIncludeTests.class)
public class DbEntityTest {

    @ArchTest
    public static ArchRule controller_classes_checks =
            ArchRuleDefinition.classes()
                    .that().resideInAPackage("..dataproviders.db.entities..")
                    .should().haveSimpleNameEndingWith("Entity");
}
