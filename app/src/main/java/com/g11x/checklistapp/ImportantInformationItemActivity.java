/*
 * Copyright © 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.g11x.checklistapp;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ImportantInformationItemActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_important_information_item);

    Button create = (Button) findViewById(R.id.create);
    create.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        ImportantInformationItemActivity.this.onClickCreate();
      }
    });
  }

  private void onClickCreate() {
    TextView title = (TextView) findViewById(R.id.title);
    String titleText = title.getText().toString();
    ImportantInformationActivity.getData().add(titleText);
    Intent intent = new Intent(this, ImportantInformationActivity.class);
    intent.putExtra("title", titleText);

    ContentValues newValues = new ContentValues();
    newValues.put("text", titleText);
    Uri mNewUri = getContentResolver().insert(
        Uri.fromParts("content", getString(R.string.content_provider_authority) + "/important_infos", nulldf),
        newValues
    );

    startActivity(intent);
  }
}