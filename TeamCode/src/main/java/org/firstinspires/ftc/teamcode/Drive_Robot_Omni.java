package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="Full Robot Omni Drive", group="PinktotheFuture")

public class Drive_Robot_Omni extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        double LFpower = 0;
        double LBpower = 0;
        double RFpower = 0;
        double RBpower = 0;
        double fastency = 1;



        DcMotor LFdrive = hardwareMap.dcMotor.get("LFdrive");
        DcMotor RBdrive = hardwareMap.dcMotor.get("RBdrive");
        DcMotor LBdrive = hardwareMap.dcMotor.get("LBdrive");
        DcMotor RFdrive = hardwareMap.dcMotor.get("RFdrive");



        LFdrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LBdrive.setDirection(DcMotorSimple.Direction.REVERSE);


        waitForStart();


        while (opModeIsActive()) {
            if (gamepad1.dpad_up)     fastency = 1;
            if (gamepad1.dpad_down)   fastency = 0.3;



            if ((gamepad1.left_stick_y + gamepad1.left_stick_x) > (gamepad1.right_stick_x + gamepad1.right_stick_y)){
                //X & Y modus
                //LEFT STICK
                RFpower = ((gamepad1.left_stick_y - gamepad1.left_stick_x) / 2);
                RBpower = ((gamepad1.left_stick_y + gamepad1.left_stick_x) / 2);
                LFpower = ((gamepad1.left_stick_y - gamepad1.left_stick_x) / 2);
                LBpower = ((gamepad1.left_stick_y + gamepad1.left_stick_x) / 2);

            }

            if ((gamepad1.right_stick_x + gamepad1.right_stick_y) > (gamepad1.left_stick_y + gamepad1.left_stick_x)){
                //TURN modus
                //RIGHT STICK
                RFpower = gamepad1.right_stick_x;
                RBpower = gamepad1.right_stick_x;
                LFpower = -gamepad1.right_stick_x;
                LBpower = -gamepad1.right_stick_x;
                }

            LFdrive.setPower(Range.clip((LFpower * fastency), -1, 1));
            RBdrive.setPower(Range.clip((RBpower * fastency), -1, 1));
            LBdrive.setPower(Range.clip((LBpower * fastency), -1, 1));
            RFdrive.setPower(Range.clip((RFpower * fastency), -1, 1));

        }

    }
}
