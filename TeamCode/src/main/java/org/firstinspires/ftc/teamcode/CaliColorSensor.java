package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.LightSensor;


/**
 * Created by robotica on 14-9-2016.
 */
@Autonomous(name="Calibrate Color", group="PinktotheFuture")
public class  CaliColorSensor extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        ColorSensor Rcolor = hardwareMap.colorSensor.get("Rcolor");
        ColorSensor Lcolor = hardwareMap.colorSensor.get("Lcolor");

        Rcolor.setI2cAddress(I2cAddr.create8bit(0x2c));
        Lcolor.setI2cAddress(I2cAddr.create8bit(0x3c));


        float RFhsvValues[] = {0F,0F,0F};
        float RBhsvValues[] = {0F,0F,0F};

        Rcolor.enableLed(false);
        Lcolor.enableLed(false);

        waitForStart();
        while (opModeIsActive()){
            Color.RGBToHSV(Rcolor.red(), Rcolor.green(), Rcolor.blue(), RFhsvValues);
            Color.RGBToHSV(Lcolor.red(), Lcolor.green(), Lcolor.blue(), RBhsvValues);

            telemetry.addData("Blue R", Rcolor.blue());
            telemetry.addData("Red R", Rcolor.red());
            telemetry.addData("", "");
            telemetry.addData("Blue L", Lcolor.blue());
            telemetry.addData("Red L", Lcolor.red());
            telemetry.update();
            sleep(500);
        }
    }
}