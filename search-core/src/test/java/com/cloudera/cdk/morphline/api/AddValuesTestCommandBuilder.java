/**
 * Copyright 2013 Cloudera Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cloudera.cdk.morphline.api;

import com.cloudera.cdk.morphline.base.AbstractCommand;
import com.typesafe.config.Config;

public final class AddValuesTestCommandBuilder implements CommandBuilder {

  @Override
  public String getName() {
    return "addValuesTest";
  }
  
  @Override
  public Command build(Config config, Command parent, Command child, MorphlineContext context) {
    return new AddValuesTestCommand(config, parent, child, context);
  }
  
  
  ///////////////////////////////////////////////////////////////////////////////
  // Nested classes:
  ///////////////////////////////////////////////////////////////////////////////
  private static final class AddValuesTestCommand extends AbstractCommand {

    private String name;
    private String value;
    
    public AddValuesTestCommand(Config config, Command parent, Command child, MorphlineContext context) {
      super(config, parent, child, context);
      this.name = Configs.getString(config, "name");
      this.value = Configs.getString(config, "value");
    }
    
    @Override
    public boolean process(Record record) {
      record.getFields().put(name, value);
      return super.process(record);
    }
    
  }
  
}
