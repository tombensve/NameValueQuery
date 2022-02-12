/*
 *
 * PROJECT
 *     Name
 *         Modelish
 *     
 *     Description
 *         Provides a RPN Query against name value set of data (Properties, Map).
 *         
 * COPYRIGHTS
 *     Copyright (C) 2022 by Natusoft AB All rights reserved.
 *     
 * LICENSE
 *     Apache 2.0 (Open Source)
 *     
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *     
 *       http://www.apache.org/licenses/LICENSE-2.0
 *     
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *     
 * AUTHORS
 *     tommy ()
 *         Changes:
 *         2022-02-11: Created!
 *
 */
package se.natusoft.tools.modelish;

/**
 * Base interface for modelish models.
 *
 * @param <T>
 */
public interface ModelishModel<T> {

    /**
     * This has to be called when all values have been set to make it impossible to modify
     * the objects content. A locked model cannot be unlocked.
     *
     * This is not required, but is a good idea to call this!
     *
     * @return itself.
     */
    T lock();
}