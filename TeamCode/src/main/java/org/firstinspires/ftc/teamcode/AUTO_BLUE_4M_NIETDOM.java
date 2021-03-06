package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name="Autonoom blauw 4M niet dom", group="PinktotheFuture")
public class AUTO_BLUE_4M_NIETDOM extends LinearOpMode {

    public void Right(double omw, double pwr) throws InterruptedException{
        DcMotor LFdrive = hardwareMap.dcMotor.get("LFdrive");
        DcMotor LBdrive = hardwareMap.dcMotor.get("LBdrive");

        LBdrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LFdrive.setDirection(DcMotorSimple.Direction.REVERSE);

        LFdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LBdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();
        LFdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        //omwentelingen invoeren, encoder ticks uitkrijgen
        double  ticks = omw * 1000;

        LFdrive.setPower(pwr);
        LBdrive.setPower(pwr);

        while (LBdrive.getCurrentPosition() < ticks && opModeIsActive()){
            waitOneFullHardwareCycle();
            telemetry.addData("R", LBdrive.getCurrentPosition());
            telemetry.update();
        }
        LFdrive.setPower(0);
        LBdrive.setPower(0);
    }

    public void Left(double omw, double pwr) throws InterruptedException{
        DcMotor RFdrive = hardwareMap.dcMotor.get("RFdrive");
        DcMotor RBdrive = hardwareMap.dcMotor.get("RBdrive");

        RBdrive.setDirection(DcMotorSimple.Direction.FORWARD);
        RFdrive.setDirection(DcMotorSimple.Direction.FORWARD);

        RFdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RBdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();
        RFdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        //omwentelingen invoeren, encoder ticks uitkrijgen
        int ticks = ((int) omw * 1120);


        RFdrive.setPower(pwr);
        RBdrive.setPower(pwr);
        RBdrive.setTargetPosition(ticks);
        RFdrive.setTargetPosition(ticks);

        while (RBdrive.getCurrentPosition() < ticks && opModeIsActive()){
            waitOneFullHardwareCycle();
            telemetry.addData("L", RBdrive.getCurrentPosition());
            telemetry.update();
        }
        sleep(300);
        RFdrive.setPower(0);
        RBdrive.setPower(0);
    }


    public void Forward(double omw, double pwr) throws InterruptedException{
        DcMotor LFdrive = hardwareMap.dcMotor.get("LFdrive");
        DcMotor RFdrive = hardwareMap.dcMotor.get("RFdrive");
        DcMotor LBdrive = hardwareMap.dcMotor.get("LBdrive");
        DcMotor RBdrive = hardwareMap.dcMotor.get("RBdrive");


        LFdrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LBdrive.setDirection(DcMotorSimple.Direction.REVERSE);
        RFdrive.setDirection(DcMotorSimple.Direction.FORWARD);
        RBdrive.setDirection(DcMotorSimple.Direction.FORWARD);

        LFdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RFdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LBdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RBdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();
        LFdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        //omwentelingen invoeren, encoder  ticks uitkrijgen
        double ticks = omw * 1000;


        LFdrive.setPower(pwr);
        RFdrive.setPower(pwr);
        LBdrive.setPower(pwr);
        RBdrive.setPower(pwr);

        while (LBdrive.getCurrentPosition() < ticks || RBdrive.getCurrentPosition() < ticks && opModeIsActive()){
            waitOneFullHardwareCycle();
            if (LBdrive.getCurrentPosition() > ticks){
                LFdrive.setPower(0);
                LBdrive.setPower(0);
            }
            if (RBdrive.getCurrentPosition() > ticks) {
                RFdrive.setPower(0);
                RBdrive.setPower(0);
            }
            if (RBdrive.getCurrentPosition() < LBdrive.getCurrentPosition()){
                LFdrive.setPower(pwr * 0.7);
                LBdrive.setPower(pwr * 0.7);
                RFdrive.setPower(pwr * 1.3);
                RFdrive.setPower(pwr * 1.3);
            }
            if (RBdrive.getCurrentPosition() > LBdrive.getCurrentPosition()){
                LFdrive.setPower(pwr * 1.3);
                LBdrive.setPower(pwr * 1.3);
                RFdrive.setPower(pwr * 0.7);
                RFdrive.setPower(pwr * 0.7);
            }
                telemetry.addData("L", LBdrive.getCurrentPosition());
                telemetry.addData("R", RBdrive.getCurrentPosition());
                telemetry.update();
        }
        LFdrive.setPower(0);
        RFdrive.setPower(0);
        LBdrive.setPower(0);
        RBdrive.setPower(0);
    }
    public void Drive(double R, float L, double pwr) throws InterruptedException{  //een void voor al het driven
        DcMotor LFdrive = hardwareMap.dcMotor.get("LFdrive");
        DcMotor RFdrive = hardwareMap.dcMotor.get("RFdrive");
        DcMotor LBdrive = hardwareMap.dcMotor.get("LBdrive");
        DcMotor RBdrive = hardwareMap.dcMotor.get("RBdrive");


        LFdrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LBdrive.setDirection(DcMotorSimple.Direction.REVERSE);


        LFdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RFdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LBdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RBdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();
        LFdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RFdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LBdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RBdrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        //omwentelingen invoeren, encoder  ticks uitkrijgen
        int Rticks = Math.getExponent(R * 1478.4);
        int Lticks = Math.getExponent(L * 1478.4);

        LFdrive.setTargetPosition(Lticks);
        LBdrive.setTargetPosition(Lticks);
        RFdrive.setTargetPosition(Rticks);
        RBdrive.setTargetPosition(Rticks);

        if (!(L == 0)){
            LFdrive.setPower(pwr);
            LBdrive.setPower(pwr);
        }
        if (!(R==0)){
            RBdrive.setPower(pwr);
            RFdrive.setPower(pwr);
        }

        while (LFdrive.getCurrentPosition() < Lticks || RFdrive.getCurrentPosition() < Rticks && opModeIsActive()){
            waitOneFullHardwareCycle();
            if (RFdrive.getCurrentPosition() > LFdrive.getCurrentPosition() && R == L){
                LFdrive.setPower(pwr * 0.7);
                LBdrive.setPower(pwr * 0.7);
                RFdrive.setPower(pwr * 1.3);
                RFdrive.setPower(pwr * 1.3);
            }
            if (RFdrive.getCurrentPosition() < LFdrive.getCurrentPosition() && R == L){
                LFdrive.setPower(pwr * 1.3);
                LBdrive.setPower(pwr * 1.3);
                RFdrive.setPower(pwr * 0.7);
                RFdrive.setPower(pwr * 0.7);
            }

            telemetry.addData("L", LFdrive.getCurrentPosition());
            telemetry.addData("R", RFdrive.getCurrentPosition());
            telemetry.update();
        }
        LFdrive.setPower(0);
        RFdrive.setPower(0);
        LBdrive.setPower(0);
        RBdrive.setPower(0);

    }
    public void RechtZetten(double h, double pwr) throws InterruptedException {

        DcMotor RFdrive = hardwareMap.dcMotor.get("RFdrive");
        DcMotor LFdrive = hardwareMap.dcMotor.get("LFdrive");
        DcMotor RBdrive = hardwareMap.dcMotor.get("RBdrive");
        DcMotor LBdrive = hardwareMap.dcMotor.get("LBdrive");

        LFdrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LBdrive.setDirection(DcMotorSimple.Direction.REVERSE);
        RFdrive.setDirection(DcMotorSimple.Direction.FORWARD);
        RBdrive.setDirection(DcMotorSimple.Direction.FORWARD);

        LightSensor Rlight = hardwareMap.lightSensor.get("Rlight");
        LightSensor Llight = hardwareMap.lightSensor.get("Llight");

        Rlight.enableLed(true);
        Llight.enableLed(true);

        LFdrive.setPower(pwr);
        RFdrive.setPower(pwr);
        LBdrive.setPower(pwr);
        RBdrive.setPower(pwr);

        while (Rlight.getLightDetected() < h || Llight.getLightDetected() < h  && opModeIsActive()) {
            waitOneFullHardwareCycle();
            if (Rlight.getLightDetected() > h){
                RFdrive.setPower(0);
                RBdrive.setPower(0);
            }
            if (Llight.getLightDetected() > h){
                LFdrive.setPower(0);
                LBdrive.setPower(0);
            }
        }
        LFdrive.setPower(0);
        RFdrive.setPower(0);
        LBdrive.setPower(0);
        RBdrive.setPower(0);
        Rlight.enableLed(false);
        Llight.enableLed(false);
    }
    public void Select(String color) throws InterruptedException{
        Servo lbs = hardwareMap.servo.get("lbs");
        Servo rbs = hardwareMap.servo.get("rbs");

        ColorSensor Rcolor = hardwareMap.colorSensor.get("Rcolor");
        ColorSensor Lcolor = hardwareMap.colorSensor.get("Lcolor");
        Lcolor.setI2cAddress(I2cAddr.create8bit(0x3c));
        Rcolor.setI2cAddress(I2cAddr.create8bit(0x2c));


        float LhsvValues[] = {0F,0F,0F};
        float RhsvValues[] = {0F,0F,0F};


        boolean loop = true;
        while (loop && opModeIsActive()) {
            waitOneFullHardwareCycle();
            Color.RGBToHSV(Lcolor.red(), Lcolor.green(), Lcolor.blue(), LhsvValues);
            Color.RGBToHSV(Rcolor.red(), Rcolor.green(), Rcolor.blue(), RhsvValues);

            double Lblue = Math.floor(Lcolor.blue());
            double Lred = Math.floor(Lcolor.red());
            double Rblue = Math.floor(Rcolor.blue());
            double Rred = Math.floor(Rcolor.red());
            telemetry.addData("", Lcolor.red());
            if (color == "red") {
                telemetry.addData("blue" ,Lblue);
                telemetry.addData("red", Lred);
                if (Lblue > Lred) {
                    telemetry.addData("Lblue > Lred", "");
                    Reverse(0.3, 0.3);
                    lbs.setPosition(0);
                    sleep(500);
                    lbs.setPosition(1);
                    sleep(500);
                    lbs.setPosition(0);
                    sleep(500);
                    lbs.setPosition(1);
                    loop = false;
                }
                if (Lred > Lblue) {
                    telemetry.addData("Lred > Lblue", "");
                    lbs.setPosition(0);
                    sleep(500);
                    lbs.setPosition(1);
                    sleep(500);
                    lbs.setPosition(0);
                    sleep(500);
                    lbs.setPosition(1);
                    loop = false;
                }
            }
            if (color == "blue"){
                telemetry.addData("blue", Rblue);
                telemetry.addData("red", Rred);
                if (Rblue > Rred) {
                    telemetry.addData("Rblue > Rred", " selecting");
                    rbs.setPosition(0.6);
                    sleep(500);
                    rbs.setPosition(0);
                    sleep(500);
                    rbs.setPosition(0.6);
                    sleep(500);
                    rbs.setPosition(0);
                    loop = false;
                }
                if (Rred > Rblue) {
                    telemetry.addData("Rred > Rblue", " selecting");
                    Reverse(0.3, 0.3);
                    rbs.setPosition(0.6);
                    sleep(500);
                    rbs.setPosition(0);
                    sleep(500);
                    rbs.setPosition(0.6);
                    sleep(500);
                    rbs.setPosition(0);
                    loop = false;
                }
            }
            telemetry.update();

        }
    }

    public void shoot(double omw, double pwr) throws InterruptedException{
        DcMotor shooter = hardwareMap.dcMotor.get("shooter");
        shooter.setDirection(DcMotorSimple.Direction.REVERSE);

        shooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();
        shooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        //omwentelingen invoeren, encoder ticks uitkrijgen
        double  ticks = omw * 1440;

        shooter.setPower(-pwr);

        while (shooter.getCurrentPosition() < ticks && opModeIsActive()){
            waitOneFullHardwareCycle();
            telemetry.addData("shooter", shooter.getCurrentPosition());
            telemetry.update();
        }
        shooter.setPower(0);
    }
    public void Reverse(double omw, double pwr) throws InterruptedException{
    DcMotor LFdrive = hardwareMap.dcMotor.get("LFdrive");
    DcMotor RFdrive = hardwareMap.dcMotor.get("RFdrive");
    DcMotor LBdrive = hardwareMap.dcMotor.get("LBdrive");
    DcMotor RBdrive = hardwareMap.dcMotor.get("RBdrive");


    LFdrive.setDirection(DcMotorSimple.Direction.FORWARD); //deze andersom omdat we achteruit gaan
    LBdrive.setDirection(DcMotorSimple.Direction.FORWARD); //deze andersom omdat we achteruit gaan
    RFdrive.setDirection(DcMotorSimple.Direction.REVERSE);
    RBdrive.setDirection(DcMotorSimple.Direction.REVERSE);


    LFdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    RFdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    LBdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    RBdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    idle();
    LFdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    RFdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    LBdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    RBdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    //omwentelingen invoeren, encoder  ticks uitkrijgen
    double ticks = omw * 1000;


    LFdrive.setPower(pwr);
    RFdrive.setPower(pwr);
    LBdrive.setPower(pwr);
    RBdrive.setPower(pwr);

    while (LBdrive.getCurrentPosition() < ticks || RBdrive.getCurrentPosition() < ticks && opModeIsActive()){
        waitOneFullHardwareCycle();
        if (LBdrive.getCurrentPosition() > ticks){
            LFdrive.setPower(0);
            LBdrive.setPower(0);
        }
        if (RBdrive.getCurrentPosition() > ticks) {
            RFdrive.setPower(0);
            RBdrive.setPower(0);
        }
        if (RBdrive.getCurrentPosition() < LBdrive.getCurrentPosition()){
            LFdrive.setPower(pwr * 0.7);
            LBdrive.setPower(pwr * 0.7);
            RFdrive.setPower(pwr * 1.3);
            RFdrive.setPower(pwr * 1.3);
        }
        if (RBdrive.getCurrentPosition() > LBdrive.getCurrentPosition()){
            LFdrive.setPower(pwr * 1.3);
            LBdrive.setPower(pwr * 1.3);
            RFdrive.setPower(pwr * 0.7);
            RFdrive.setPower(pwr * 0.7);
        }
        telemetry.addData("L", LBdrive.getCurrentPosition());
        telemetry.addData("R", RBdrive.getCurrentPosition());
        telemetry.update();
    }
    LFdrive.setPower(0);
    RFdrive.setPower(0);
    LBdrive.setPower(0);
    RBdrive.setPower(0);
}


    @Override
    public  void runOpMode() throws InterruptedException {


        Left(1, 0.5);





    }
}