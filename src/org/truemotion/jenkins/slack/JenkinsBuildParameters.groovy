package org.truemotion.jenkins.slack

import hudson.model.ParameterValue
import hudson.model.ParametersAction

@NonCPS
String getBuildParameters() {
  def build_params = ""
  def parameters = currentBuild.rawBuild.getAction(ParametersAction.class)
  if (parameters != null) {
    build_params = "Build Parameters:\n"
    for(ParameterValue p in parameters) {
      build_params = build_params + ("\t" + p.name + ": " + p.value + "\n")
    }
  }
  return build_params
}