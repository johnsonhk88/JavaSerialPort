/*******************************************************************************
 * Copyright 
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
 *******************************************************************************/
package testcase;

import serialportutil.AbstractSerialCommand;
import serialportutil.CommandBatch;

/**
 * Direct send command to serial<BR>
 * Using System.out as output
 * 
 */
public class SimpleCommand extends AbstractSerialCommand {
    @Override
    protected void setup() {
        // Setup serial
        setSerialPortConf(SerialFactory.DEFAULT_PORT);
        addOutputStream(System.out);
    }

    @Override
    protected void processCommand() throws Exception {
        // Send command "ps" to serial port,
        sendCommand(0x3, 100, 2);
        sendCommand("ps | grep sh\n", 100, 10);
    }

    public static void main(String[] args) {
        CommandBatch.addClazz(SimpleCommand.class);
        CommandBatch.go();
    }

}
