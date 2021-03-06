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

package org.example;

import com.sun.faces.annotation.Attribute;
import com.sun.faces.annotation.Property;

/**
 *
 * @author gjmurphy
 */
public class SuperBean05 {
    
    @Property(isHidden=true, displayName="This element is not the display name", category="myFavoriteProperties")
    private String one;

    public String getOne() {
        return this.one;
    }

    public void setOne(String one) {
        this.one = one;
    }
    
    @Property(isAttribute=false, displayName="This element is not the display name", category="myFavoriteProperties")
    private String two;

    public String getTwo() {
        return this.two;
    }

    public void setTwo(String two) {
        this.two = two;
    }
    
    @Property(isHidden=true, isAttribute=false, category="myFavoriteProperties")
    private String three;

    public String getThree() {
        return this.three;
    }

    public void setThree(String three) {
        this.three = three;
    }
    
}
