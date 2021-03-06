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

package com.sun.webui.jsf.renderkit.html;

import com.sun.webui.jsf.component.CommonTasksSection;
import com.sun.webui.jsf.renderkit.html.CommonTasksSectionRenderer;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
/**
 *
 * @author vm157347
 */
public class CommonTasksSectionDesignTimeRenderer extends AbstractDesignTimeRenderer{
    
    /**
     * Creates a new instance of CommonTasksSectionDesignTimeRenderer
     */
    public CommonTasksSectionDesignTimeRenderer() {
        super(new CommonTasksSectionRenderer());
    }
    
    
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        StringBuffer sb = new StringBuffer();
        int tmp = -1;
        if (component instanceof CommonTasksSection) {
           String style = (String) component.getAttributes().get("style");
            if ((style != null) && (style.length() > 0)) {
                    sb.append(style);                                    
            }
            
           if (style == null) {
                sb.append(" width:800px"); // NOI18N
           }else if ((style != null) && !style.contains("width")) {
                sb.append("; width:800px"); // NOI18N
           }
      
  
            ((CommonTasksSection)component).setStyle(sb.toString());
            super.encodeBegin(context, component);
        }
         
    }
}
