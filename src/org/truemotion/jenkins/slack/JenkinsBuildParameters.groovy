package org.truemotion.jenkins.slack

import hudson.model.*

@NonCPS
String getBuildParameters() {
  def build_params = ""
  def parameters = currentBuild?.actions.find{ it instanceof ParametersAction }?.parameters
  if (parameters != null) {
    build_params = "Build Parameters:\n"
    parameters.each {
      build_params = build_params + ("\t" + it.name + ": " + it.dump() + "\n")
    }
  }
  return build_params
}