package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;


/**
 * Created by robotica on 14-9-2016.
 */
@Autonomous(name="Autonoom bal tikken", group="PinktotheFuture")
@Disabled
public class SimpleAuto extends LinearOpMode {

    double fastency = 0.5;
    public void shoot(double omw, double pwr) throws InterruptedException{

        double SweeperPower;
        DcMotor LFdrive = hardwareMap.dcMotor.get("LFdrive");
        DcMotor RBdrive = hardwareMap.dcMotor.get("RBdrive");
        DcMotor LBdrive = hardwareMap.dcMotor.get("LBdrive");
        DcMotor RFdrive = hardwareMap.dcMotor.get("RFdrive");
        DcMotor Sweeper = hardwareMap.dcMotor.get("sweeper");
        DcMotor shooter = hardwareMap.dcMotor.get("shooter");
        shooter.setDirection(DcMotorSimple.Direction.REVERSE);

        shooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();
        shooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //omwentelingen invoeren, encoder ticks uitkrijgen

        double ticks = omw * 1440;

        shooter.setPower(pwr);
        while (shooter.getCurrentPosition() < ticks && opModeIsActive()){
        }
        shooter.setPower(0);

    }
    @Override
    public void runOpMode() throws InterruptedException {

        double omw = 7;
        double pwr = 0.8;
        double ticks = omw * 1000;

        waitForStart();

        DcMotor LFdrive = hardwareMap.dcMotor.get("LFdrive");
        DcMotor RBdrive = hardwareMap.dcMotor.get("RBdrive");
        DcMotor LBdrive = hardwareMap.dcMotor.get("LBdrive");
        DcMotor RFdrive = hardwareMap.dcMotor.get("RFdrive");
        LFdrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LBdrive.setDirection(DcMotorSimple.Direction.REVERSE);

        LFdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RFdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LBdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RBdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();
        LFdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        LFdrive.setPower(pwr);
        RFdrive.setPower(pwr);
        LBdrive.setPower(pwr);
        RBdrive.setPower(pwr);

        while (LFdrive.getCurrentPosition() < ticks || RFdrive.getCurrentPosition() < ticks && opModeIsActive()){
            if (LFdrive.getCurrentPosition() > ticks){
                LFdrive.setPower(0);
                LBdrive.setPower(0);
            }
            if (RFdrive.getCurrentPosition() > ticks) {
                RFdrive.setPower(0);
                RBdrive.setPower(0);
            }
        }
        LFdrive.setPower(0);
        RFdrive.setPower(0);
        LBdrive.setPower(0);
        RBdrive.setPower(0);
        shoot(2, 0.5);
    }



}