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

import com.sun.rave.designtime.DesignBean;
import com.sun.rave.designtime.DesignProperty;
import com.sun.rave.designtime.Result;
import com.sun.webui.jsf.component.util.DesignMessageUtil;
import com.sun.webui.jsf.design.AbstractDesignInfo;

/**
 * <p>
 * Design time behavior for an <code>PageAlert</code> component.
 * </p>
 * 
 * @author Edwin Goei
 */
public class PageAlertDesignInfo extends AbstractDesignInfo {

    public PageAlertDesignInfo() {
        super(PageAlert.class);
    }

    public Result beanCreatedSetup(DesignBean bean) {
        bean.getProperty("type").setValue("error"); //NOI18N
        return Result.SUCCESS;
    }

}