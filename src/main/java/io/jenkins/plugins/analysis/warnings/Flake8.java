package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;

import hudson.Extension;

import edu.hm.hafner.analysis.parser.violations.Flake8Adapter;

/**
 * Provides a parser and customized messages for Android Lint.
 *
 * @author Ullrich Hafner
 */
public class Flake8 extends StaticAnalysisTool {
    static final String ID = "flake8";

    /** Creates a new instance of {@link Flake8}. */
    @DataBoundConstructor
    public Flake8() {
        // empty constructor required for stapler
    }

    @Override
    public Flake8Adapter createParser() {
        return new Flake8Adapter();
    }

    /** Descriptor for this static analysis tool. */
    @Extension
    public static class Descriptor extends StaticAnalysisToolDescriptor {
        public Descriptor() {
            super(ID);
        }

        @Nonnull
        @Override
        public String getDisplayName() {
            return Messages.Violations_Flake8();
        }
    }
}
