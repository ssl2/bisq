/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.desktop.components;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Skin;

import com.sun.javafx.scene.control.skin.ButtonSkin;

import static bisq.desktop.components.TooltipUtil.showTooltipIfTruncated;

public class AutoTooltipButton extends Button {

    public AutoTooltipButton() {
        super();
    }

    public AutoTooltipButton(String text) {
        super(text);
    }

    public AutoTooltipButton(String text, Node graphic) {
        super(text, graphic);
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new AutoTooltipButtonSkin(this);
    }

    private class AutoTooltipButtonSkin extends ButtonSkin {
        public AutoTooltipButtonSkin(Button button) {
            super(button);
        }

        @Override
        protected void layoutChildren(double x, double y, double w, double h) {
            super.layoutChildren(x, y, w, h);
            showTooltipIfTruncated(this, getSkinnable());
        }
    }
}