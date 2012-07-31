package org.grules.scripts.ast

import static org.grules.TestScriptEntities.*

import org.grules.Grules
import org.grules.script.RulesScriptResult

import spock.lang.Specification

class AstFunctionsTest extends Specification {

  def "Static functions are created with right signature"() {
    setup:
      RulesScriptResult result = Grules.applyRules(AstFunctionsGrules, [(PARAMETER_NAME): PARAMETER_VALUE])
    expect:
      result.cleanParameters[PARAMETER_NAME] == PARAMETER_VALUE
  }

  def "Shortcut functions are created with right signature"() {
    setup:
      RulesScriptResult result = Grules.applyRules(AstFunctionsGrules, [(PARAMETER_NAME_AUX): PARAMETER_VALUE])
    expect:
      result.cleanParameters[PARAMETER_NAME_AUX] == PARAMETER_VALUE
  }

  def "Common functions are included"() {
    setup:
      RulesScriptResult result = Grules.applyRules(AstIncludeGrules, [(PARAMETER_NAME): PARAMETER_VALUE])
    expect:
      result.cleanParameters[PARAMETER_NAME] == PARAMETER_VALUE
  }
}