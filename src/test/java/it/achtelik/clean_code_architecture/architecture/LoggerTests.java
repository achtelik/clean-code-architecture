package it.achtelik.clean_code_architecture.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.runner.RunWith;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "it.achtelik.example.javamodules", importOptions = ImportOption.DoNotIncludeTests.class)
public class LoggerTests {

    @ArchTest
    public static ArchRule no_wrong_logger_checks =
            ArchRuleDefinition.noClasses().should().accessClassesThat().resideInAPackage("..log4j..")
                    .orShould().accessClassesThat().resideInAnyPackage("java.util.logging..");
}
