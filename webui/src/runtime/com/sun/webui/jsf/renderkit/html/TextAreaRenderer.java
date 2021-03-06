/*
 * Copyright (c) 2007, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * TextAreaRenderer.java
 */
package com.sun.webui.jsf.renderkit.html;

import com.sun.faces.annotation.Renderer;
import java.io.IOException;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.theme.Theme;
import com.sun.webui.jsf.theme.ThemeStyles;
import com.sun.webui.jsf.util.MessageUtil;
import com.sun.webui.jsf.util.ThemeUtilities;

/**
 * <p>Renderer for TextAreaRenderer {@link TextArea} component.</p>
 */
@Renderer(@Renderer.Renders(componentFamily = "com.sun.webui.jsf.TextArea"))
public class TextAreaRenderer extends FieldRenderer {

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {

        if (!(component instanceof TextArea)) {
            Object[] params = {component.toString(),
                this.getClass().getName(),
                TextArea.class.getName()};
            String message = MessageUtil.getMessage("com.sun.webui.jsf.resources.LogMessages", //NOI18N
                    "Renderer.component", params);              //NOI18N
            throw new FacesException(message);
        }

        super.renderField(context, (TextArea) component, "textarea", getStyles(context));
    }

    @Override
    String[] getStyles(FacesContext context) {
        Theme theme = ThemeUtilities.getTheme(context);
        String[] styles = new String[4];
        styles[0] = theme.getStyleClass(ThemeStyles.TEXT_AREA);
        styles[1] = theme.getStyleClass(ThemeStyles.TEXT_AREA_DISABLED);
        styles[2] = theme.getStyleClass(ThemeStyles.HIDDEN);
        styles[3] = theme.getStyleClass(ThemeStyles.LIST_ALIGN);
        return styles;
    }
}
