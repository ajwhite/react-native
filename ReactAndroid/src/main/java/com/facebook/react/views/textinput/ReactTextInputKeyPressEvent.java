/**
 * Copyright (c) 2015-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Event emitted by EditText native view when a key is pressed.
 * VisibleForTesting from {@link TextInputEventsTestCase}.
 */
public class ReactTextInputKeyPressEvent extends Event<ReactTextChangedEvent> {

  public static final String EVENT_NAME = "keyPress";

  private String mKey;
  private int mEventCount;

  public ReactTextInputKeyPressEvent(
          int viewId,
          long timestampMs,
          String key) {
    super(viewId, timestampMs);
    mKey = key;
  }

  @Override
  public String getEventName() {
    return EVENT_NAME;
  }

  @Override
  public void dispatch(RCTEventEmitter rctEventEmitter) {
    rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }

  private WritableMap serializeEventData() {
    WritableMap eventData = Arguments.createMap();
    eventData.putString("key", mKey);
    eventData.putInt("target", getViewTag());
    return eventData;
  }
}
