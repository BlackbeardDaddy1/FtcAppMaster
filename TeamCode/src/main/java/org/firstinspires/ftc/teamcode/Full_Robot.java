package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="Full Robot", group="PinktotheFuture")

public class Full_Robot extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        double fastency = 0.5;
        double left;
        double right;
        double SweeperPower;
        double lbsPosition;
        double rbsPosition;
        double shooterservoPosition;
        int shooterPosition = 0;
        double linearglidePower;
        boolean DriveDirection = true;
        double shooterServoTime = 0;



        Servo lbs = hardwareMap.servo.get ("lbs"); //left beacon servo
        Servo rbs = hardwareMap.servo.get("rbs");
        Servo shooterservo = hardwareMap.servo.get("shooterservo");
        Servo capbalopen = hardwareMap.servo.get("capbalopen");


        DcMotor LinearGlide = hardwareMap.dcMotor.get("linear glide");
        DcMotor LFdrive = hardwareMap.dcMotor.get("LFdrive");
        DcMotor RBdrive = hardwareMap.dcMotor.get("RBdrive");
        DcMotor LBdrive = hardwareMap.dcMotor.get("LBdrive");
        DcMotor RFdrive = hardwareMap.dcMotor.get("RFdrive");
        DcMotor Sweeper = hardwareMap.dcMotor.get("sweeper");
        DcMotor shooter = hardwareMap.dcMotor.get("shooter");
        shooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();
        shooter.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        shooter.setPower(0.5);
        shooter.setDirection(DcMotorSimple.Direction.REVERSE);


        LFdrive.setDirection(DcMotorSimple.Direction.REVERSE);
        LBdrive.setDirection(DcMotorSimple.Direction.REVERSE);
        Sweeper.setDirection(DcMotorSimple.Direction.REVERSE);



        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)

        while (opModeIsActive()) {
            left = gamepad1.right_stick_y;
            right = gamepad1.left_stick_y;
            SweeperPower = 0;
            lbsPosition = 0.8;
            rbsPosition = 0;
            shooterservoPosition = 0.8;
            linearglidePower = 0;


            if (gamepad1.y) linearglidePower = 1;
            if (gamepad1.a) linearglidePower = -1;
            if (gamepad1.b) capbalopen.setPosition(0.9);
            if (gamepad1.x) capbalopen.setPosition(0.5);


            if (gamepad2.right_trigger > 0.2)   SweeperPower = -gamepad2.right_trigger;
            if (gamepad2.left_trigger > 0.2)    SweeperPower = gamepad2.left_trigger;


            if (gamepad1.dpad_up)     fastency = 1;
            if (gamepad1.dpad_down)   fastency = 0.2;
            if (gamepad1.dpad_left) {
                if (DriveDirection) {
                    DriveDirection = false;
                    RBdrive.setDirection(DcMotorSimple.Direction.FORWARD);
                    RFdrive.setDirection(DcMotorSimple.Direction.FORWARD);
                    LBdrive.setDirection(DcMotorSimple.Direction.REVERSE);
                    LFdrive.setDirection(DcMotorSimple.Direction.REVERSE);
                }
                if (!DriveDirection){
                    DriveDirection = true;
                    RBdrive.setDirection(DcMotorSimple.Direction.REVERSE);
                    RFdrive.setDirection(DcMotorSimple.Direction.REVERSE);
                    LBdrive.setDirection(DcMotorSimple.Direction.FORWARD);
                    LFdrive.setDirection(DcMotorSimple.Direction.FORWARD);
                }
            }


            if (gamepad2.dpad_left) {
                shooterPosition = shooterPosition + 2240;
                shooter.setTargetPosition(shooterPosition);
                //shooterServoTime = getRuntime();
            }
            if (gamepad2.dpad_down)  shooterPosition = shooterPosition - 20;
            if (gamepad2.dpad_up)    shooterPosition = shooterPosition + 20;
            if (gamepad2.dpad_right) shooterservoPosition = 0.4;

            //if ((shooterServoTime + 0.5) > getRuntime() ){
            //    if ((shooterServoTime + 1.5) < getRuntime()) {
            //        shooterservoPosition = 0.4;
            //    }}


            if (gamepad2.b) lbsPosition = 0;
            if (gamepad2.a) rbsPosition = 0.6;

            LFdrive.setPower(left * fastency);
            RBdrive.setPower(right * fastency);
            LBdrive.setPower(left * fastency);
            RFdrive.setPower(right * fastency);
            Sweeper.setPower(SweeperPower);
            lbs.setPosition(lbsPosition);
            rbs.setPosition(rbsPosition);
            shooter.setTargetPosition(shooterPosition);
            shooterservo.setPosition(shooterservoPosition);
            LinearGlide.setPower(linearglidePower * 0);

            telemetry.addData("shooter", shooter.getCurrentPosition());
            telemetry.update();
        }

    }
}
