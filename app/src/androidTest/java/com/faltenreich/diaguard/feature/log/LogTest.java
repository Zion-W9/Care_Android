package com.faltenreich.diaguard.feature.log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.faltenreich.diaguard.test.junit.rule.TestRuleFactory;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LogTest {

    @Rule
    public final TestRule rule = TestRuleFactory.forFragment(LogFragment.class);

    @Test
    public void launchingFragment_shouldSucceed() {}
}
