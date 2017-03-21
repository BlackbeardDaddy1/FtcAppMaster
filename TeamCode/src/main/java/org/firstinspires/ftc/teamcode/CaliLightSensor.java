package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.LightSensor;


/**
 * Created by robotica on 14-9-2016.
 */
@Autonomous(name="Calibrate Light", group="PinktotheFuture")
public class CaliLightSensor extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        LightSensor Rlight = hardwareMap.lightSensor.get("Rlight");
        LightSensor Llight = hardwareMap.lightSensor.get("Llight");

        Rlight.enableLed(true);
        Llight.enableLed(true);
        waitForStart();
        while (isStarted()){
            telemetry.addData("Llight:", Llight.getLightDetected());
            telemetry.addData("Rlight:", Rlight.getLightDetected());
            telemetry.addData("Llight RAW:", Llight.getRawLightDetected());
            telemetry.addData("Rlight RAW:", Rlight.getRawLightDetected());
            telemetry.update();
        }
    }
}