"use client";

import { useSuspenseQuery } from "@tanstack/react-query";
import { useTRPC } from "@/trpc/client";
import { LoadingState } from "@/components/loading-state";
import { ErrorState } from "@/components/error-state";
import { DataTable } from "../components/data-table";
import { columns } from "../components/columns";
import { EmptyState } from "@/components/empty-state";
import { useAgentsFilters } from "../../hooks/user-agents-filters";
import { DataPagination } from "../components/data-pagination";
import { useRouter } from "next/navigation";

export const AgentsView = () => {
    const router = useRouter();
    const [filters, setFilters] = useAgentsFilters();

    const trpc = useTRPC();
    const { data } = useSuspenseQuery(trpc.agents.getMany.queryOptions({
        ...filters,
    }));

    return ( 
        <div className="flex-1 pb-4 px-4 md:px-8 flex flex-col gap-y-4">
            <DataTable 
                data={data.items} 
                columns={columns} 
                onRowClick={(row) => router.push(`/agents/${row.id}`)}
            />
            <DataPagination
                page={filters.page}
                totalPages={data.totalPages}
                onPageChange={(page) => setFilters({ page })}
            />
            {data.items.length === 0 && (
                <EmptyState
                    title="No Agents Found"
                    description="Try creating a new agent."
                />
            )}
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
