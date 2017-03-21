package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name="Test Motor", group="PinktotheFuture")
@Disabled

public class TestMotor extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor test = hardwareMap.dcMotor.get("test");
        test.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()){
            test.setPower(gamepad1.left_stick_y);
        }

    }
}
