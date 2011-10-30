/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dwalkes.generic_deskclock;

import android.os.Bundle;

/**
 * Full screen alarm alert: pops visible indicator and plays alarm tone. This
 * activity displays the alert in full screen in order to be secure. The
 * background is the current wallpaper.
 */
public class AlarmAlertFullScreen extends AlarmAlert {
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
    }
    
    @Override
    public void onBackPressed() {
        // Don't allow back to dismiss.
        return;
    }
}
