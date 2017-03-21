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



@Autonomous(name="Autonoom rood 4M", group="PinktotheFuture")
public class AUTO_RED_4M extends LinearOpMode {

    public void Right(double omw, double pwr) throws InterruptedException{
        DcMotor LFdrive = hardwareMap.dcMotor.get("LFdrive");
        DcMotor LBdrive = hardwareMap.dcMotor.get("LBdrive");

        LFdrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LBdrive.setDirection(DcMotorSimple.Direction.REVERSE);

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

        RFdrive.setDirection(DcMotorSimple.Direction.FORWARD);
        RBdrive.setDirection(DcMotorSimple.Direction.FORWARD);

        RFdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RBdrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();
        RFdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        //omwentelingen invoeren, encoder ticks uitkrijgen
        double  ticks = omw * 1000;

        RFdrive.setPower(pwr);
        RBdrive.setPower(pwr);

        while (RBdrive.getCurrentPosition() < ticks && opModeIsActive()){
            waitOneFullHardwareCycle();
            telemetry.addData("L", RBdrive.getCurrentPosition());
            telemetry.update();
        }
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
        RBdrive.setDirection(DcMotorSimple.Direction.FORWARD);
        RFdrive.setDirection(DcMotorSimple.Direction.FORWARD);


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
    public void Drive(double R, double L, double pwr) throws InterruptedException{  //een void voor al het driven
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
        LFdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBdrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        //omwentelingen invoeren, encoder  ticks uitkrijgen
        double Rticks = R * 1000;
        double Lticks = L * 1000;


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
            if (LFdrive.getCurrentPosition() > Lticks){
                LFdrive.setPower(0);
                LBdrive.setPower(0);
            }
            if (RFdrive.getCurrentPosition() > Rticks) {
                RFdrive.setPower(0);
                RBdrive.setPower(0);
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
        RBdrive.setDirection(DcMotorSimple.Direction.FORWARD);
        RFdrive.setDirection(DcMotorSimple.Direction.FORWARD);

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
    public void Reverse(double omw, double pwr) throws InterruptedException{
        DcMotor LFdrive = hardwareMap.dcMotor.get("LFdrive");
        DcMotor RFdrive = hardwareMap.dcMotor.get("RFdrive");
        DcMotor LBdrive = hardwareMap.dcMotor.get("LBdrive");
        DcMotor RBdrive = hardwareMap.dcMotor.get("RBdrive");


        LFdrive.setDirection(DcMotorSimple.Direction.FORWARD); //alles andersom omdat we achteruit gaan
        LBdrive.setDirection(DcMotorSimple.Direction.FORWARD);
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
                telemetry.addData("","red");
                if (Lblue > Lred) {
                    telemetry.addData("Lblue > Lred", "");
                    Reverse(0.3, 0.3);
                    lbs.setPosition(0);
                    sleep(500);
                    lbs.setPosition(1);
                    sleep(200);
                    lbs.setPosition(0);
                    sleep(500);
                    lbs.setPosition(1);
                    loop = false;
                }
                if (Lred > Lblue) {
                    telemetry.addData("Lred > Lblue", "");
                    lbs.setPosition(0);
                    sleep(500);
                    lbs.setPosition(0.6);
                    sleep(200);
                    lbs.setPosition(0);
                    sleep(500);
                    lbs.setPosition(0.6);
                    loop = false;
                }
            }
            if (color == "blue"){
                telemetry.addData("", "blue");
                if (Rblue > Rred) {
                    telemetry.addData("Rblue > Rred", "");
                    rbs.setPosition(0.6);
                    sleep(500);
                    rbs.setPosition(0);
                    sleep(200);
                    rbs.setPosition(0.6);
                    sleep(500);
                    rbs.setPosition(0);
                    loop = false;
                }
                if (Rred > Rblue) {
                    telemetry.addData("Rred > Rblue", "");
                    Reverse(0.3, 0.3);
                    rbs.setPosition(0.6);
                    sleep(500);
                    rbs.setPosition(0);
                    sleep(200);
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


    @Override
    public  void runOpMode() throws InterruptedException {


        Servo lbs = hardwareMap.servo.get("lbs");
        Servo rbs = hardwareMap.servo.get("rbs");
        Servo shooterservo = hardwareMap.servo.get("shooterservo");
        shooterservo.setPosition(1);
        lbs.setPosition(1);
        rbs.setPosition(0);

        waitForStart();



        Forward(0.5, 0.25);
        sleep(100);
        shoot(1.5, 0.5);
        shooterservo.setPosition(0.5);
        sleep(100);
        shoot(1.5, 0.5);

        Left(1.55, 0.2);
        sleep(100);
        Forward(4.2, 0.35);
        sleep(100);
        Right(1.65, 0.2);
        sleep(100);
        Forward(0.1, 0.2);
        sleep(100);






        //eerste beacon
        RechtZetten(0.4, 0.12);
        sleep(100);
        Select("red");
        sleep(100);
        Forward(0.1, 0.4);
        RechtZetten(0.4, 0.12);

        Forward(3.4, 0.2);

        RechtZetten(0.4, 0.12);
        Select("red");



    }
}