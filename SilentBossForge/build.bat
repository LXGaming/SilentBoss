@echo off
echo LX_Gaming's Build Batch Script.

if exist gradlew (
  echo Successfully found 'gradlew'.
) else (
  echo Failed to find 'gradlew'!
  exit /B
)

if exist gradle.properties (
  echo Successfully found 'gradle.properties' File.
) else (
  echo Failed to find 'gradle.properties' File, Creating...
  echo org.gradle.jvmargs=-Xmx512M>gradle.properties
  if exist gradle.properties (
    echo Successfully created 'gradle.properties' File.
  ) else (
    echo Failed to create 'gradle.properties' File, Exiting...
    exit /B
  )
)
cmd /k gradlew clean build
pause