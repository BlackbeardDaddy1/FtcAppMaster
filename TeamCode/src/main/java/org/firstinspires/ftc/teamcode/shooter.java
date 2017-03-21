package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name="shooter", group="PinktotheFuture")

public class shooter extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor shooter = hardwareMap.dcMotor.get("shooter");
        shooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();
        shooter.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        shooter.setPower(0.5);
        shooter.setDirection(DcMotorSimple.Direction.REVERSE);


        waitForStart();

        while (opModeIsActive()){
            waitOneFullHardwareCycle();
            shooter.setTargetPosition(0);
            sleep(500);
        }

    }
}
