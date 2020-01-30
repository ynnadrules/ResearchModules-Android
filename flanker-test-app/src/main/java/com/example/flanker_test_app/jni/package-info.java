/**
 * This package contains SwiftModule annotations. Package level annotations are not available in Kotlin.
 * This is why JNI bridge classes are all implemented in java. 2018/11/19 - darryl
 */
@SwiftModule(
        moduleName = "FlankerKitCoreProject",
        importPackages = {"FlankerKitCore", "FlankerKit"},
        customTypeMappings = {
                // @TypeMapping(swiftType = "Color", javaClass = AndroidColor.class)
        })
package com.example.flanker_test_app.jni;

import com.readdle.codegen.anotation.SwiftModule;
import com.readdle.codegen.anotation.TypeMapping;

