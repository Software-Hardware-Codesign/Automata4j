/*
 * BSD 3-Clause License
 *
 * Copyright (c) 2023, The AvrSandbox Project, Automata4j
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.avrsandbox.fsa.core;

import com.avrsandbox.fsa.core.state.AutoState;
import com.avrsandbox.fsa.core.state.NextStateNotFoundException;

/**
 * Represents a machine system transition with one next-state {@link Transition#nextState}.
 *
 * @param <I> a class-generic representing the input value type
 * @param <O> a class-generic representing the tracer object (output) value type
 * @author pavl_g
 */
public class Transition<I, O> {
    
    private AutoState<I, O> nextState;

    /**
     * Instantiates a transition with an empty next-state.
     */
    public Transition() {
    }

    /**
     * Instantiates a transition with a next-state.
     * 
     * @param nextState the next-state object to assign
     */
    public Transition(AutoState<I, O> nextState) {
        this.nextState = nextState;
    }

    /**
     * Assigns a next-state into your heap memory.
     * Default value is (not-null).
     * 
     * @param nextState the next-state object to assign
     * @throws NextStateNotFoundException thrown if the next-state is null
     */
    public void setNextState(AutoState<I, O> nextState) {
        /* a business exception if there is no next-state assigned */
        if (nextState == null) {
            throw new NextStateNotFoundException();
        }
        this.nextState = nextState;
    }

    /**
     * Loads the state from your heap into your stack memory.
     * 
     * @return the next state of the transition system
     */
    public AutoState<I, O> getNextState() throws NextStateNotFoundException {
        return nextState;
    }

    /**
     * Removes the state from the heap memory.
     * 
     * Warning, this removes the deep copy aka. the real pointer
     * from your heap memory, so you might expect uneventful results.
     */
    public void remove() {
        nextState = null;
    }
}