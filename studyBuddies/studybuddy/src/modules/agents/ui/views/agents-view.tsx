"use client";

import { useSuspenseQuery } from "@tanstack/react-query";
import { useTRPC } from "@/trpc/client";
import { LoadingState } from "@/components/loading-state";
import { ErrorState } from "@/components/error-state";

export const AgentsView = () => {
    const trpc = useTRPC();
    const { data } = useSuspenseQuery(trpc.agents.getMany.queryOptions());

    return ( 
        <div>
            {JSON.stringify(data, null, 2)}
        </div>
    );
};

export const AgentsViewLoading = () => {
    return ( 
        <LoadingState
            title="Loading Agents"
            description="Please wait while we fetch the agents."
        />
    );
};

export const AgentsViewError = () => {
    return ( 
        <ErrorState
            title="Error Loading Agents"
            description="It's not you, it's us or maybe its you. Either way, we are working on it."
        />
    );
};
