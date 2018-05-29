/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jenkins.x.idea.plugin;

import io.jenkins.x.client.tree.TreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

/**
 */
public class JenkinsXTreeCellRenderer extends DefaultTreeCellRenderer implements TreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component component = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        if (value instanceof TreeItem) {
            TreeItem treeItem = (TreeItem) value;

            JLabel label = null;
            if (component instanceof JLabel) {
                label = (JLabel) component;
            } else {
                label = new JLabel();
            }
            label.setText(treeItem.getLabel());
            label.setToolTipText(treeItem.getTooltip());
            Icon icon = IconHelper.getIcon(treeItem.getIconPath());
            if (icon != null) {
                label.setIcon(icon);
            }
            return label;
        }
        return component;
    }
}
