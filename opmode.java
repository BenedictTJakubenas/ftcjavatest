package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class opmode extends LinearOpMode {
    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;
    private CRServo liftarm;
    private DcMotor lift;

    @Override
    public void runOpMode() throws InterruptedException {
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");
        liftarm = hardwareMap.crservo.get("liftarm");
        lift = hardwareMap.dcMotor.get("lift");

        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE); // reverses leftfront motor direction because flipped
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE); // reverses leftback motor direction because flipped
        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);


        telemetry.addLine("Initialized");
        //gamepad1

        waitForStart();
        telemetry.addLine("Initialized");
        while (opModeIsActive())
            //turn right
            while (Math.abs(gamepad1.right_stick_x) > 0.05) {
                leftFront.setPower(gamepad1.right_stick_x);
                leftBack.setPower(gamepad1.right_stick_x);
                rightFront.setPower(-gamepad1.right_stick_x);
                rightBack.setPower(-gamepad1.right_stick_x);
            }
        while (gamepad1.right_bumper)
        {
            leftFront.setPower(-1);
            leftBack.setPower(1);
            rightFront.setPower(1);
            rightBack.setPower(-1);
        }
        while (gamepad1.left_bumper)
        {
            leftFront.setPower(1);
            leftBack.setPower(-1);
            rightFront.setPower(-1);
            rightBack.setPower(1);
        }
        while (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x)) {
            leftFront.setPower(-gamepad1.left_stick_y);
            leftBack.setPower(-gamepad1.left_stick_y);
            rightFront.setPower(-gamepad1.left_stick_y);
            rightBack.setPower(-gamepad1.left_stick_y);
        }
        while (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
            rightFront.setPower(-gamepad1.left_stick_x);
            rightBack.setPower(gamepad1.left_stick_x);
            leftFront.setPower(gamepad1.left_stick_x);
            leftBack.setPower(-gamepad1.left_stick_x);
        }
       /* if (Math.abs(rsx) < 0.05 && Math.abs(rsy) < 0.05 && Math.abs(lsx) < 0.05 && Math.abs(lsy) < 0.05) {
            leftFront.setPower(0);
            leftBack.setPower(0);
            rightFront.setPower(0);
            rightBack.setPower(0);
        }*/




        //gamepad2

        while (Math.abs(gamepad2.right_stick_y) > 0.05) {
            liftarm.setPower(gamepad2.right_stick_y);
        }
        while (Math.abs(gamepad2.left_stick_y) > 0.05) {
            lift.setPower(gamepad2.left_stick_y);
        }
    }
}
