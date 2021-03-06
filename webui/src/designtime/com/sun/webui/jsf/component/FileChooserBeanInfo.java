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

package com.sun.webui.jsf.component;

import java.beans.BeanDescriptor;

import com.sun.webui.jsf.component.util.DesignUtil;
import com.sun.webui.jsf.design.CategoryDescriptors;

import com.sun.rave.designtime.Constants;
import com.sun.rave.designtime.CategoryDescriptor;

/**
 * BeanInfo for the {@link com.sun.webui.jsf.component.FileChooser} component.
 */
public class FileChooserBeanInfo extends FileChooserBeanInfoBase {
    
    protected CategoryDescriptor[] categoryDescriptors;
    
    /**
     * Default constructor.
     */
    public FileChooserBeanInfo() {
        // Add default body and parameter names to the event descriptors for the
        // valueChange event and the pseudo-event validate.
        DesignUtil.updateInputEventSetDescriptors(this);
    }              
    
    /**
     * Return the <code>BeanDescriptor</code> for this bean.
     */     
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor beanDescriptor = super.getBeanDescriptor();
        
        // Do not allow the component to be resized.
        beanDescriptor.setValue(Constants.BeanDescriptor.RESIZE_CONSTRAINTS,
                new Integer(Constants.ResizeConstraints.NONE));        
        return beanDescriptor;
    }  
    
    protected CategoryDescriptor[] getCategoryDescriptors() {   
        // A hack to add the category descriptor for events and to ensure that
        // Events always occurs after Data. Since events are not properties,
        // they cannot be annotated with category information.
        if (categoryDescriptors == null) {
            CategoryDescriptor[] superCategoryDescriptors = super.getCategoryDescriptors();
            categoryDescriptors = new CategoryDescriptor[superCategoryDescriptors.length + 1];
            for (int i = 0, j = 0; i < superCategoryDescriptors.length; i++, j++) {
                categoryDescriptors[j] = superCategoryDescriptors[i];
                if (categoryDescriptors[j] == CategoryDescriptors.DATA)
                    categoryDescriptors[++j] = CategoryDescriptors.EVENTS;
            }
        }
        return categoryDescriptors;
    }
}
