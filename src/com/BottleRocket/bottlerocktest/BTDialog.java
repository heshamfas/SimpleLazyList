package com.BottleRocket.bottlerocktest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class BTDialog extends DialogFragment {
	static BTDialog newInstance(String title) {
		BTDialog fragment = new BTDialog();
		Bundle args = new Bundle();
		args.putString("title", title);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		String title = getArguments().getString("title");
		return new AlertDialog.Builder(getActivity())
				.setIcon(R.drawable.ic_launcher)
				.setTitle(title)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						((BRTest) getActivity()).doPositiveClick();
					}
				})
				.create();
	}
}
