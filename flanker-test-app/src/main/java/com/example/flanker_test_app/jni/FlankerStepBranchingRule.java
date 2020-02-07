/*
 * BSD 3-Clause License
 *
 * Copyright 2020  Sage Bionetworks. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1.  Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * 2.  Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * 3.  Neither the name of the copyright holder(s) nor the names of any contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission. No license is granted to the trademarks of
 * the copyright holders even if such marks are included in this software.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.example.flanker_test_app.jni;

import androidx.annotation.Nullable;

import com.readdle.codegen.anotation.SwiftFunc;
import com.readdle.codegen.anotation.SwiftGetter;
import com.readdle.codegen.anotation.SwiftSetter;
import com.readdle.codegen.anotation.SwiftValue;

import java.util.ArrayList;

@SwiftValue
public class FlankerStepBranchingRule {

    @Nullable
    private String description;

    @Nullable
    @SwiftGetter
    public native String getDescription();

    @Nullable
    private String nextStepName;

    @Nullable
    @SwiftGetter
    public native String getNextStepName();

    @Nullable
    private FlankerConditionType conditionType;

    @Nullable
    @SwiftGetter
    public native FlankerConditionType getConditionType();

    @Nullable
    private ArrayList<FlankerBranchingCriteria> criterias;

    @Nullable
    @SwiftGetter
    public native ArrayList<FlankerBranchingCriteria> getCriterias();

    @SwiftSetter
    public native void setCriterias(@Nullable ArrayList<FlankerBranchingCriteria> criterias);

    @Nullable
    private FlankerStepGroup stepGroup;

    @Nullable
    @SwiftGetter
    public native FlankerStepGroup getStepGroup();

    @SwiftSetter
    public native void setStepGroup(@Nullable FlankerStepGroup stepGroup);

    @SwiftFunc
    public native static FlankerStepBranchingRule init(
            @Nullable String description,
            @Nullable String nextStepName,
            @Nullable FlankerConditionType conditionType,
            @Nullable ArrayList<FlankerBranchingCriteria> criterias,
            @Nullable FlankerStepGroup stepGroup);


    private FlankerStepBranchingRule() {}
}
