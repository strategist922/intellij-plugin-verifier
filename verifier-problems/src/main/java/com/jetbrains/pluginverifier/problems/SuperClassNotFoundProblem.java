package com.jetbrains.pluginverifier.problems;

import com.jetbrains.pluginverifier.problems.ClassProblem;
import com.jetbrains.pluginverifier.utils.MessageUtils;
import org.jetbrains.annotations.NotNull;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SuperClassNotFoundProblem extends ClassProblem {

  private String mySuperClassName;

  public SuperClassNotFoundProblem() {

  }

  public SuperClassNotFoundProblem(@NotNull String className, @NotNull String superClassName) {
    super(className);
    mySuperClassName = superClassName;
  }

  @Override
  public String getDescription() {
    return "class has unknown super: " + MessageUtils.convertClassName(mySuperClassName) + " class:" + getClassNameHuman();
  }

  @NotNull
  @Override
  public String evaluateUID() {
    return evaluateUID(mySuperClassName, getClassName());
  }

  public String getSuperClassName() {
    return mySuperClassName;
  }

  public void setSuperClassName(String superClassName) {
    mySuperClassName = superClassName;
    cleanUid();
  }
}
