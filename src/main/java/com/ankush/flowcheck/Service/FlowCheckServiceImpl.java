package com.ankush.flowcheck.Service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.ankush.flowcheck.model.UserInput;

@Service
public class FlowCheckServiceImpl implements FlowCheckService {

	int rn;
	String rn1;
	int minrn1 = 2000;
	int maxrn2 = 4000;
	int density = 990;
	float miu = (float) 0.01;

	public int calculateReynlodsNumber(int velocity, float diameter) {
		int rn = (int) (density * velocity * diameter / miu);
		return rn;
	}

	@Override
	public HashMap<String, String> flowCheck(UserInput userInput) {
		HashMap<String, String> hm = new HashMap<String, String>();

		FlowCheckServiceImpl flow = new FlowCheckServiceImpl();
		int rn = flow.calculateReynlodsNumber(userInput.getVelocity(), userInput.getDiameter());
		this.rn = rn;
		this.rn1 = Integer.toString(rn);
		System.out.println("Reynlod's Number is = " + rn);

		// Flow Through Pipes
		if (userInput.getPipeOrPlate().equalsIgnoreCase("pipe")) {
			if (this.rn < 2000) {
				hm.put("Reynold's Number = ", this.rn1);
				hm.put("Flow is= ", "Laminar Flow");
				double sqrt = Math.sqrt(this.rn);
				float boundarylayerthickness = (float) (5 * userInput.getX() * 1000 / sqrt);
				String string3 = Float.toString(boundarylayerthickness);
				hm.put("Boundary Layer Thickness= ", string3 +"mm");
				float local = (float) (0.664 / sqrt);
				System.out.println(local);
				String string = Float.toString(local);
				hm.put("Local=", string);
				float average = (float) (0.664 * 2 / sqrt);
				System.err.println(average);
				String string2 = Float.toString(average);
				hm.put("Average=", string2);
			} else if (this.rn <= this.maxrn2 && this.minrn1 <= this.rn) {
				hm.put("Reynold's Number = ", this.rn1);
				hm.put("Flow is= ", "Transient Flow");
			} else {
				hm.put("Reynold's Number = ", this.rn1);
				hm.put("Flow is= ", "Turbulent Flow ");
				double pow = Math.pow(this.rn, 0.2);
				float blt = (float) (0.376 * userInput.getX() * 1000 / pow);
				String string = Float.toString(blt);
				hm.put("Boundary Layer Thickness= ", string+"mm");
				float local = (float) (0.059 / pow);
				String string2 = Float.toString(local);
				hm.put("Local= ", string2);
				float average = (float) (0.074 / pow);
				String string3 = Float.toString(average);
				hm.put("Average= ", string3);

			}
		}

		// FLow through Plates
		else {
			if (this.rn < 500000) {
				hm.put("Reynold's Number = ", this.rn1);
				hm.put("Flow is= ", "Laminar Flow");
				double sqrt = Math.sqrt(this.rn);
				float boundarylayerthickness = (float) (5 * userInput.getX() * 1000 / sqrt);
				String string3 = Float.toString(boundarylayerthickness);
				hm.put("Boundary Layer Thickness= ", string3+"mm");
				float local = (float) (0.664 / sqrt);
				System.out.println(local);
				String string = Float.toString(local);
				hm.put("Local= ", string);
				float average = (float) (0.664 * 2 / sqrt);
				System.err.println(average);
				String string2 = Float.toString(average);
				hm.put("Average= ", string2);
			} else {
				hm.put("Reynold's Number = ", this.rn1);
				hm.put("Flow is= ", "Turbulent Flow= ");
				if (this.rn < 10000000) {
					double pow = Math.pow(this.rn, 0.2);
					float blt = (float) (0.376 * userInput.getX() * 1000 / pow);
					String string = Float.toString(blt);
					hm.put("Boundary Layer Thickness= ", string+"mm");
					float local = (float) (0.059 / pow);
					String string2 = Float.toString(local);
					hm.put("Local= ", string2);
					float average = (float) (0.074 / pow);
					String string3 = Float.toString(average);
					hm.put("Average= ", string3);
				} else {
					double pow = Math.pow(this.rn, 0.1666);
					double log = Math.log(10);
					double d = log * this.rn;
					double pow2 = Math.pow(d, 2.58);
					System.err.println(pow);
					System.out.println(pow2);
					float blt = (float) (0.22 * 1000 / pow);
					String string = Float.toString(blt);
					hm.put("Boundary Layer Thickness= ", string+"mm");
					float local = (float) (0.37 / pow2);
					String string2 = Float.toString(local);
					hm.put("Local= ", string2);
					float average = (float) (0.455 / pow2);
					String string3 = Float.toString(average);
					hm.put("Average= ", string3);
				}
			}
		}
		return hm;

	}

}
