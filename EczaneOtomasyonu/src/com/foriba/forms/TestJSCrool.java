package com.foriba.forms;
import javax.swing.JScrollPane;
import java.awt.Component;

public final class TestJSCrool {
	/**
	 * @wbp.factory
	 * @wbp.factory.parameter.source viewportView urunTablosu
	 * @wbp.factory.parameter.source rowHeaderView chckbxNewCheckBox
	 */
	public static JScrollPane createJScrollPane(Component viewportView, Component rowHeaderView) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(viewportView);
		scrollPane.setRowHeaderView(rowHeaderView);
		return scrollPane;
	}
}